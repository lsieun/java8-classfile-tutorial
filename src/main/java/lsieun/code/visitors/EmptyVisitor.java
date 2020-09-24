package lsieun.code.visitors;

import lsieun.code.opcode.*;

public class EmptyVisitor implements OpcodeVisitor {
    @Override
    public void visitNOP(NOP obj) {

    }

    // region opcode const
    @Override
    public void visitACONST_NULL(ACONST_NULL obj) {

    }

    @Override
    public void visitICONST_M1(ICONST_M1 obj) {

    }

    @Override
    public void visitICONST_0(ICONST_0 obj) {

    }

    @Override
    public void visitICONST_1(ICONST_1 obj) {

    }

    @Override
    public void visitICONST_2(ICONST_2 obj) {

    }

    @Override
    public void visitICONST_3(ICONST_3 obj) {

    }

    @Override
    public void visitICONST_4(ICONST_4 obj) {

    }

    @Override
    public void visitICONST_5(ICONST_5 obj) {

    }

    @Override
    public void visitLCONST_0(LCONST_0 obj) {

    }

    @Override
    public void visitLCONST_1(LCONST_1 obj) {

    }

    @Override
    public void visitFCONST_0(FCONST_0 obj) {

    }

    @Override
    public void visitFCONST_1(FCONST_1 obj) {

    }

    @Override
    public void visitFCONST_2(FCONST_2 obj) {

    }

    @Override
    public void visitDCONST_0(DCONST_0 obj) {

    }

    @Override
    public void visitDCONST_1(DCONST_1 obj) {

    }


    @Override
    public void visitBIPUSH(BIPUSH obj) {

    }

    @Override
    public void visitSIPUSH(SIPUSH obj) {

    }

    @Override
    public void visitLDC(LDC obj) {

    }

    @Override
    public void visitLDC_W(LDC_W obj) {

    }

    @Override
    public void visitLDC2_W(LDC2_W obj) {

    }
    // endregion

    // region opcode local variable
    @Override
    public void visitILOAD(ILOAD obj) {

    }

    @Override
    public void visitLLOAD(LLOAD obj) {

    }

    @Override
    public void visitFLOAD(FLOAD obj) {

    }

    @Override
    public void visitDLOAD(DLOAD obj) {

    }

    @Override
    public void visitALOAD(ALOAD obj) {

    }

    @Override
    public void visitILOAD_0(ILOAD_0 obj) {

    }

    @Override
    public void visitILOAD_1(ILOAD_1 obj) {

    }

    @Override
    public void visitILOAD_2(ILOAD_2 obj) {

    }

    @Override
    public void visitILOAD_3(ILOAD_3 obj) {

    }

    @Override
    public void visitLLOAD_0(LLOAD_0 obj) {

    }

    @Override
    public void visitLLOAD_1(LLOAD_1 obj) {

    }

    @Override
    public void visitLLOAD_2(LLOAD_2 obj) {

    }

    @Override
    public void visitLLOAD_3(LLOAD_3 obj) {

    }

    @Override
    public void visitFLOAD_0(FLOAD_0 obj) {

    }

    @Override
    public void visitFLOAD_1(FLOAD_1 obj) {

    }

    @Override
    public void visitFLOAD_2(FLOAD_2 obj) {

    }

    @Override
    public void visitFLOAD_3(FLOAD_3 obj) {

    }

    @Override
    public void visitDLOAD_0(DLOAD_0 obj) {

    }

    @Override
    public void visitDLOAD_1(DLOAD_1 obj) {

    }

    @Override
    public void visitDLOAD_2(DLOAD_2 obj) {

    }

    @Override
    public void visitDLOAD_3(DLOAD_3 obj) {

    }

    @Override
    public void visitALOAD_0(ALOAD_0 obj) {

    }

    @Override
    public void visitALOAD_1(ALOAD_1 obj) {

    }

    @Override
    public void visitALOAD_2(ALOAD_2 obj) {

    }

    @Override
    public void visitALOAD_3(ALOAD_3 obj) {

    }

    @Override
    public void visitISTORE(ISTORE obj) {

    }

    @Override
    public void visitLSTORE(LSTORE obj) {

    }

    @Override
    public void visitFSTORE(FSTORE obj) {

    }

    @Override
    public void visitDSTORE(DSTORE obj) {

    }

    @Override
    public void visitASTORE(ASTORE obj) {

    }

    @Override
    public void visitISTORE_0(ISTORE_0 obj) {

    }

    @Override
    public void visitISTORE_1(ISTORE_1 obj) {

    }

    @Override
    public void visitISTORE_2(ISTORE_2 obj) {

    }

    @Override
    public void visitISTORE_3(ISTORE_3 obj) {

    }

    @Override
    public void visitLSTORE_0(LSTORE_0 obj) {

    }

    @Override
    public void visitLSTORE_1(LSTORE_1 obj) {

    }

    @Override
    public void visitLSTORE_2(LSTORE_2 obj) {

    }

    @Override
    public void visitLSTORE_3(LSTORE_3 obj) {

    }

    @Override
    public void visitFSTORE_0(FSTORE_0 obj) {

    }

    @Override
    public void visitFSTORE_1(FSTORE_1 obj) {

    }

    @Override
    public void visitFSTORE_2(FSTORE_2 obj) {

    }

    @Override
    public void visitFSTORE_3(FSTORE_3 obj) {

    }

    @Override
    public void visitDSTORE_0(DSTORE_0 obj) {

    }

    @Override
    public void visitDSTORE_1(DSTORE_1 obj) {

    }

    @Override
    public void visitDSTORE_2(DSTORE_2 obj) {

    }

    @Override
    public void visitDSTORE_3(DSTORE_3 obj) {

    }

    @Override
    public void visitASTORE_0(ASTORE_0 obj) {

    }

    @Override
    public void visitASTORE_1(ASTORE_1 obj) {

    }

    @Override
    public void visitASTORE_2(ASTORE_2 obj) {

    }

    @Override
    public void visitASTORE_3(ASTORE_3 obj) {

    }
    // endregion

    // region opcode array
    @Override
    public void visitIALOAD(IALOAD obj) {

    }

    @Override
    public void visitLALOAD(LALOAD obj) {

    }

    @Override
    public void visitFALOAD(FALOAD obj) {

    }

    @Override
    public void visitDALOAD(DALOAD obj) {

    }

    @Override
    public void visitAALOAD(AALOAD obj) {

    }

    @Override
    public void visitBALOAD(BALOAD obj) {

    }

    @Override
    public void visitCALOAD(CALOAD obj) {

    }

    @Override
    public void visitSALOAD(SALOAD obj) {

    }

    @Override
    public void visitIASTORE(IASTORE obj) {

    }

    @Override
    public void visitLASTORE(LASTORE obj) {

    }

    @Override
    public void visitFASTORE(FASTORE obj) {

    }

    @Override
    public void visitDASTORE(DASTORE obj) {

    }

    @Override
    public void visitAASTORE(AASTORE obj) {

    }

    @Override
    public void visitBASTORE(BASTORE obj) {

    }

    @Override
    public void visitCASTORE(CASTORE obj) {

    }

    @Override
    public void visitSASTORE(SASTORE obj) {

    }
    // endregion

    // region opcode f_stack
    @Override
    public void visitPOP(POP obj) {

    }

    @Override
    public void visitPOP2(POP2 obj) {

    }

    @Override
    public void visitDUP(DUP obj) {

    }

    @Override
    public void visitDUP_X1(DUP_X1 obj) {

    }

    @Override
    public void visitDUP_X2(DUP_X2 obj) {

    }

    @Override
    public void visitDUP2(DUP2 obj) {

    }

    @Override
    public void visitDUP2_X1(DUP2_X1 obj) {

    }

    @Override
    public void visitDUP2_X2(DUP2_X2 obj) {

    }

    @Override
    public void visitSWAP(SWAP obj) {

    }
    // endregion

    // region opcode arithmetic
    @Override
    public void visitIADD(IADD obj) {

    }

    @Override
    public void visitLADD(LADD obj) {

    }

    @Override
    public void visitFADD(FADD obj) {

    }

    @Override
    public void visitDADD(DADD obj) {

    }

    @Override
    public void visitISUB(ISUB obj) {

    }

    @Override
    public void visitLSUB(LSUB obj) {

    }

    @Override
    public void visitFSUB(FSUB obj) {

    }

    @Override
    public void visitDSUB(DSUB obj) {

    }

    @Override
    public void visitIMUL(IMUL obj) {

    }

    @Override
    public void visitLMUL(LMUL obj) {

    }

    @Override
    public void visitFMUL(FMUL obj) {

    }

    @Override
    public void visitDMUL(DMUL obj) {

    }

    @Override
    public void visitIDIV(IDIV obj) {

    }

    @Override
    public void visitLDIV(LDIV obj) {

    }

    @Override
    public void visitFDIV(FDIV obj) {

    }

    @Override
    public void visitDDIV(DDIV obj) {

    }

    @Override
    public void visitIREM(IREM obj) {

    }

    @Override
    public void visitLREM(LREM obj) {

    }

    @Override
    public void visitFREM(FREM obj) {

    }

    @Override
    public void visitDREM(DREM obj) {

    }

    @Override
    public void visitINEG(INEG obj) {

    }

    @Override
    public void visitLNEG(LNEG obj) {

    }

    @Override
    public void visitFNEG(FNEG obj) {

    }

    @Override
    public void visitDNEG(DNEG obj) {

    }

    @Override
    public void visitISHL(ISHL obj) {

    }

    @Override
    public void visitLSHL(LSHL obj) {

    }

    @Override
    public void visitISHR(ISHR obj) {

    }

    @Override
    public void visitLSHR(LSHR obj) {

    }

    @Override
    public void visitIUSHR(IUSHR obj) {

    }

    @Override
    public void visitLUSHR(LUSHR obj) {

    }

    @Override
    public void visitIAND(IAND obj) {

    }

    @Override
    public void visitLAND(LAND obj) {

    }

    @Override
    public void visitIOR(IOR obj) {

    }

    @Override
    public void visitLOR(LOR obj) {

    }

    @Override
    public void visitIXOR(IXOR obj) {

    }

    @Override
    public void visitLXOR(LXOR obj) {

    }

    @Override
    public void visitIINC(IINC obj) {

    }
    // endregion

    // region opcode conversion
    @Override
    public void visitI2L(I2L obj) {

    }

    @Override
    public void visitI2F(I2F obj) {

    }

    @Override
    public void visitI2D(I2D obj) {

    }

    @Override
    public void visitL2I(L2I obj) {

    }

    @Override
    public void visitL2F(L2F obj) {

    }

    @Override
    public void visitL2D(L2D obj) {

    }

    @Override
    public void visitF2I(F2I obj) {

    }

    @Override
    public void visitF2L(F2L obj) {

    }

    @Override
    public void visitF2D(F2D obj) {

    }

    @Override
    public void visitD2I(D2I obj) {

    }

    @Override
    public void visitD2L(D2L obj) {

    }

    @Override
    public void visitD2F(D2F obj) {

    }

    @Override
    public void visitI2B(I2B obj) {

    }

    @Override
    public void visitI2C(I2C obj) {

    }

    @Override
    public void visitI2S(I2S obj) {

    }
    // endregion

    // region opcode compare
    @Override
    public void visitLCMP(LCMP obj) {

    }

    @Override
    public void visitFCMPL(FCMPL obj) {

    }

    @Override
    public void visitFCMPG(FCMPG obj) {

    }

    @Override
    public void visitDCMPL(DCMPL obj) {

    }

    @Override
    public void visitDCMPG(DCMPG obj) {

    }
    // endregion

    // region opcode if
    @Override
    public void visitIFEQ(IFEQ obj) {

    }

    @Override
    public void visitIFNE(IFNE obj) {

    }

    @Override
    public void visitIFLT(IFLT obj) {

    }

    @Override
    public void visitIFGE(IFGE obj) {

    }

    @Override
    public void visitIFGT(IFGT obj) {

    }

    @Override
    public void visitIFLE(IFLE obj) {

    }

    @Override
    public void visitIF_ICMPEQ(IF_ICMPEQ obj) {

    }

    @Override
    public void visitIF_ICMPNE(IF_ICMPNE obj) {

    }

    @Override
    public void visitIF_ICMPLT(IF_ICMPLT obj) {

    }

    @Override
    public void visitIF_ICMPGE(IF_ICMPGE obj) {

    }

    @Override
    public void visitIF_ICMPGT(IF_ICMPGT obj) {

    }

    @Override
    public void visitIF_ICMPLE(IF_ICMPLE obj) {

    }

    @Override
    public void visitIF_ACMPEQ(IF_ACMPEQ obj) {

    }

    @Override
    public void visitIF_ACMPNE(IF_ACMPNE obj) {

    }

    @Override
    public void visitIFNULL(IFNULL obj) {

    }

    @Override
    public void visitIFNONNULL(IFNONNULL obj) {

    }
    // endregion

    // region opcode branch
    @Override
    public void visitGOTO(GOTO obj) {

    }

    @Override
    public void visitGOTO_W(GOTO_W obj) {

    }

    @Override
    public void visitJSR(JSR obj) {

    }

    @Override
    public void visitJSR_W(JSR_W obj) {

    }

    @Override
    public void visitRET(RET obj) {

    }

    @Override
    public void visitTABLESWITCH(TABLESWITCH obj) {

    }

    @Override
    public void visitLOOKUPSWITCH(LOOKUPSWITCH obj) {

    }
    // endregion

    // region opcode return
    @Override
    public void visitIRETURN(IRETURN obj) {

    }

    @Override
    public void visitLRETURN(LRETURN obj) {

    }

    @Override
    public void visitFRETURN(FRETURN obj) {

    }

    @Override
    public void visitDRETURN(DRETURN obj) {

    }

    @Override
    public void visitARETURN(ARETURN obj) {

    }

    @Override
    public void visitRETURN(RETURN obj) {

    }
    // endregion

    // region opcode c_field
    @Override
    public void visitGETSTATIC(GETSTATIC obj) {

    }

    @Override
    public void visitPUTSTATIC(PUTSTATIC obj) {

    }

    @Override
    public void visitGETFIELD(GETFIELD obj) {

    }

    @Override
    public void visitPUTFIELD(PUTFIELD obj) {

    }
    // endregion

    // region opcode invoke
    @Override
    public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {

    }

    @Override
    public void visitINVOKESPECIAL(INVOKESPECIAL obj) {

    }

    @Override
    public void visitINVOKESTATIC(INVOKESTATIC obj) {

    }

    @Override
    public void visitINVOKEINTERFACE(INVOKEINTERFACE obj) {

    }

    @Override
    public void visitINVOKEDYNAMIC(INVOKEDYNAMIC obj) {

    }
    // endregion

    // region opcode allocate
    @Override
    public void visitNEW(NEW obj) {

    }

    @Override
    public void visitNEWARRAY(NEWARRAY obj) {

    }

    @Override
    public void visitANEWARRAY(ANEWARRAY obj) {

    }

    @Override
    public void visitARRAYLENGTH(ARRAYLENGTH obj) {

    }

    @Override
    public void visitMULTIANEWARRAY(MULTIANEWARRAY obj) {

    }
    // endregion

    // region opcode xxx
    @Override
    public void visitATHROW(ATHROW obj) {

    }

    @Override
    public void visitCHECKCAST(CHECKCAST obj) {

    }

    @Override
    public void visitINSTANCEOF(INSTANCEOF obj) {

    }

    @Override
    public void visitMONITORENTER(MONITORENTER obj) {

    }

    @Override
    public void visitMONITOREXIT(MONITOREXIT obj) {

    }

    @Override
    public void visitWIDE(WIDE obj) {

    }

    @Override
    public void visitBREAKPOINT(BREAKPOINT obj) {

    }

    @Override
    public void visitIMPDEP1(IMPDEP1 obj) {

    }

    @Override
    public void visitIMPDEP2(IMPDEP2 obj) {

    }
    // endregion

}
