package com.tubers.antilight.client;


import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;
import scala.tools.asm.Opcodes;

import java.util.Arrays;
import java.util.Iterator;

public class ALTransformer implements IClassTransformer {

    // {class normal name , class obfuscated name} -  1.8.9
    private static final String[][] transformedClasses = {{"net.minecraft.world.World", "adm"}};


    @Override
    public byte[] transform(String name, String transformedName, byte[] classBytes)
    {
        boolean isObfuscated = !name.equals(transformedName);
        int index = -1;
        int counter = -1;
        for(String[] str : transformedClasses)
        {
            counter++;
            if (Arrays.asList(str).indexOf(name) != -1)
            {
                index = counter;
                break;
            }
        }

        return index != -1 ? transform(index, classBytes, isObfuscated, transformedName) : classBytes;
    }



    private static byte[] transform(int index, byte[] classBytes, boolean isObfuscated, String transformedName)
    {
        System.out.println(transformedName + " being transformed. Is Obf: " + isObfuscated);

        try
        {
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(classBytes);
            classReader.accept(classNode, ClassReader.SKIP_FRAMES);

            switch (index)
            {
                case 0:
                    transformWorld(classNode, isObfuscated);
                    break;
            }

            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(classWriter);
            return classWriter.toByteArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return classBytes;
    }


    private static void transformWorld(ClassNode classNode, boolean isObfuscated)
    {

        /* net/minecraft/world/World.getRawLight / func_175638_a */
        final String targetMethodName = isObfuscated ? "a" : "getRawLight";

        /* (Lnet/minecraft/util/BlockPos;Lnet/minecraft/world/EnumSkyBlock;)I */
        final String targetMethodDesc = isObfuscated ? "(Lcj;Lads;)I" : "(Lnet/minecraft/util/BlockPos;Lnet/minecraft/world/EnumSkyBlock;)I";

        final String goalInvokeDesc = isObfuscated ? "(Lafh;Ladq;Lcj;)I" : "(Lnet/minecraft/block/Block;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/BlockPos;)I";

        for(MethodNode method : classNode.methods)
        {
            if (method.name.equals(targetMethodName) && method.desc.equals(targetMethodDesc))
            {
                System.out.println("In target method " + targetMethodName + ", Patching!");

                /* before patch:
                   0: aload_2
			       1: getstatic     #136                // Field net/minecraft/world/EnumSkyBlock.SKY:Lnet/minecraft/world/EnumSkyBlock;
			       4: if_acmpne     18
			       7: aload_0
			       8: aload_1
			       9: invokevirtual #160                // Method isAgainstSky:(Lnet/minecraft/util/BlockPos;)Z
			      12: ifeq          18
			      15: bipush        15
			      17: ireturn
			      18: aload_0
			      19: aload_1
			      20: invokevirtual #80                 // Method getBlockState:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
			      23: invokeinterface #81,  1           // InterfaceMethod net/minecraft/block/state/IBlockState.getBlock:()Lnet/minecraft/block/Block;
			      28: astore_3
			      29: aload_3
			      30: aload_0
			      31: aload_1
			      32: invokevirtual #486                // Method net/minecraft/block/Block.getLightValue:(Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/BlockPos;)I
			      35: istore        4
			      [... many more...]
                 */

                AbstractInsnNode targetNode = null;
                Iterator<AbstractInsnNode> iter = method.instructions.iterator();
                boolean found = false;
                while (iter.hasNext())
                {
                    // check all nodes
                    targetNode = iter.next();

                    // find the first ASTORE node, it stores the Block reference for the Block.getLightValue call
                    if (targetNode.getOpcode() == Opcodes.ASTORE)
                    {
                        VarInsnNode astore = (VarInsnNode) targetNode;
                        System.out.println("Found ASTORE Node, is writing variable number: " + astore.var);

                        // go further until ISTORE is hit
                        while (targetNode.getOpcode() != Opcodes.ISTORE)
                        {
                            if (targetNode instanceof MethodInsnNode)
                            {
                                MethodInsnNode mNode = (MethodInsnNode) targetNode;
                                System.out.printf("found target node, opcode: %d, %s %s %s\n", mNode.getOpcode(), mNode.owner, mNode.name, mNode.desc);
                                found = true;

                                iter.remove();
                                targetNode = iter.next(); // select next node as target
                                break;
                            }
                            targetNode = iter.next();
                            System.out.printf("Node %s, opcode %d\n", targetNode, targetNode.getOpcode());
                        }
                        break;
                    }
                }

                if (found)
                {

                    // now write our replacement before the target node
                    method.instructions.insertBefore(targetNode, new MethodInsnNode(Opcodes.INVOKESTATIC, "com/tubers/antilight/Antilight", "getLightValue", goalInvokeDesc, false));
                    //System.out.println("Injecting method.");
                }
                break;
            }

        }
    }


}


