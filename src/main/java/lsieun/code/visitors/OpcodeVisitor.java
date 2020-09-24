package lsieun.code.visitors;

import lsieun.code.opcode.*;

/**
 * Interface implementing the OpcodeVisitor pattern programming style.
 * I.e., a class that implements this interface can handle all types of
 * instructions with the properly typed methods just by calling the accept()
 * d_method.
 */
public interface OpcodeVisitor {

    void visitNOP(NOP obj);

    // region opcode const
    void visitACONST_NULL(ACONST_NULL obj);

    void visitICONST_M1(ICONST_M1 obj);

    void visitICONST_0(ICONST_0 obj);

    void visitICONST_1(ICONST_1 obj);

    void visitICONST_2(ICONST_2 obj);

    void visitICONST_3(ICONST_3 obj);

    void visitICONST_4(ICONST_4 obj);

    void visitICONST_5(ICONST_5 obj);

    void visitLCONST_0(LCONST_0 obj);

    void visitLCONST_1(LCONST_1 obj);

    void visitFCONST_0(FCONST_0 obj);

    void visitFCONST_1(FCONST_1 obj);

    void visitFCONST_2(FCONST_2 obj);

    void visitDCONST_0(DCONST_0 obj);

    void visitDCONST_1(DCONST_1 obj);

    void visitBIPUSH(BIPUSH obj);

    void visitSIPUSH(SIPUSH obj);

    void visitLDC(LDC obj);

    void visitLDC_W(LDC_W obj);

    void visitLDC2_W(LDC2_W obj);
    // endregion

    // region opcode local variable
    void visitILOAD(ILOAD obj);

    void visitLLOAD(LLOAD obj);

    void visitFLOAD(FLOAD obj);

    void visitDLOAD(DLOAD obj);

    void visitALOAD(ALOAD obj);

    void visitILOAD_0(ILOAD_0 obj); // opcode = 26

    void visitILOAD_1(ILOAD_1 obj);

    void visitILOAD_2(ILOAD_2 obj);

    void visitILOAD_3(ILOAD_3 obj);

    void visitLLOAD_0(LLOAD_0 obj); // opcode = 30

    void visitLLOAD_1(LLOAD_1 obj);

    void visitLLOAD_2(LLOAD_2 obj);

    void visitLLOAD_3(LLOAD_3 obj);

    void visitFLOAD_0(FLOAD_0 obj); // opcode = 34

    void visitFLOAD_1(FLOAD_1 obj);

    void visitFLOAD_2(FLOAD_2 obj);

    void visitFLOAD_3(FLOAD_3 obj);

    void visitDLOAD_0(DLOAD_0 obj); // opcode = 38

    void visitDLOAD_1(DLOAD_1 obj);

    void visitDLOAD_2(DLOAD_2 obj);

    void visitDLOAD_3(DLOAD_3 obj);

    void visitALOAD_0(ALOAD_0 obj); // opcode = 42

    void visitALOAD_1(ALOAD_1 obj);

    void visitALOAD_2(ALOAD_2 obj);

    void visitALOAD_3(ALOAD_3 obj);

    void visitIALOAD(IALOAD obj); // opcode = 46

    void visitLALOAD(LALOAD obj);

    void visitFALOAD(FALOAD obj);

    void visitDALOAD(DALOAD obj);

    void visitAALOAD(AALOAD obj);

    void visitBALOAD(BALOAD obj);

    void visitCALOAD(CALOAD obj);

    void visitSALOAD(SALOAD obj);

    void visitISTORE(ISTORE obj); // opcode = 54

    void visitLSTORE(LSTORE obj);

    void visitFSTORE(FSTORE obj);

    void visitDSTORE(DSTORE obj);

    void visitASTORE(ASTORE obj);

    void visitISTORE_0(ISTORE_0 obj); // opcode = 59

    void visitISTORE_1(ISTORE_1 obj);

    void visitISTORE_2(ISTORE_2 obj);

    void visitISTORE_3(ISTORE_3 obj);

    void visitLSTORE_0(LSTORE_0 obj); // opcode = 63

    void visitLSTORE_1(LSTORE_1 obj);

    void visitLSTORE_2(LSTORE_2 obj);

    void visitLSTORE_3(LSTORE_3 obj);

    void visitFSTORE_0(FSTORE_0 obj); // opcode = 67

    void visitFSTORE_1(FSTORE_1 obj);

    void visitFSTORE_2(FSTORE_2 obj);

    void visitFSTORE_3(FSTORE_3 obj);

    void visitDSTORE_0(DSTORE_0 obj); // opcode = 71

    void visitDSTORE_1(DSTORE_1 obj);

    void visitDSTORE_2(DSTORE_2 obj);

    void visitDSTORE_3(DSTORE_3 obj);

    void visitASTORE_0(ASTORE_0 obj); // opcode = 75

    void visitASTORE_1(ASTORE_1 obj);

    void visitASTORE_2(ASTORE_2 obj);

    void visitASTORE_3(ASTORE_3 obj);

    void visitIASTORE(IASTORE obj); // opcode = 79

    void visitLASTORE(LASTORE obj);

    void visitFASTORE(FASTORE obj);

    void visitDASTORE(DASTORE obj);

    void visitAASTORE(AASTORE obj);

    void visitBASTORE(BASTORE obj);

    void visitCASTORE(CASTORE obj);

    void visitSASTORE(SASTORE obj);
    // endregion

    // region opcode f_stack
    void visitPOP(POP obj); // opcode = 87

    void visitPOP2(POP2 obj);

    void visitDUP(DUP obj);

    void visitDUP_X1(DUP_X1 obj);

    void visitDUP_X2(DUP_X2 obj);

    void visitDUP2(DUP2 obj);

    void visitDUP2_X1(DUP2_X1 obj);

    void visitDUP2_X2(DUP2_X2 obj);

    void visitSWAP(SWAP obj);
    // endregion

    // region opcode arithmetic
    void visitIADD(IADD obj); // opcode = 96

    void visitLADD(LADD obj);

    void visitFADD(FADD obj);

    void visitDADD(DADD obj);

    void visitISUB(ISUB obj);

    void visitLSUB(LSUB obj);

    void visitFSUB(FSUB obj);

    void visitDSUB(DSUB obj);

    void visitIMUL(IMUL obj);

    void visitLMUL(LMUL obj);

    void visitFMUL(FMUL obj);

    void visitDMUL(DMUL obj);

    void visitIDIV(IDIV obj);

    void visitLDIV(LDIV obj);

    void visitFDIV(FDIV obj);

    void visitDDIV(DDIV obj);

    void visitIREM(IREM obj);

    void visitLREM(LREM obj);

    void visitFREM(FREM obj);

    void visitDREM(DREM obj);

    void visitINEG(INEG obj);

    void visitLNEG(LNEG obj);

    void visitFNEG(FNEG obj);

    void visitDNEG(DNEG obj);

    void visitISHL(ISHL obj);

    void visitLSHL(LSHL obj);

    void visitISHR(ISHR obj);

    void visitLSHR(LSHR obj);

    void visitIUSHR(IUSHR obj);

    void visitLUSHR(LUSHR obj);

    void visitIAND(IAND obj);

    void visitLAND(LAND obj);

    void visitIOR(IOR obj);

    void visitLOR(LOR obj);

    void visitIXOR(IXOR obj);

    void visitLXOR(LXOR obj);

    void visitIINC(IINC obj); // opcode = 132
    // endregion

    // region opcode conversion
    void visitI2L(I2L obj); // opcode = 133

    void visitI2F(I2F obj);

    void visitI2D(I2D obj);

    void visitL2I(L2I obj);

    void visitL2F(L2F obj);

    void visitL2D(L2D obj);

    void visitF2I(F2I obj);

    void visitF2L(F2L obj);

    void visitF2D(F2D obj);

    void visitD2I(D2I obj);

    void visitD2L(D2L obj);

    void visitD2F(D2F obj);

    void visitI2B(I2B obj); // opcode = 145

    void visitI2C(I2C obj);

    void visitI2S(I2S obj);
    // endregion

    // region opcode compare
    void visitLCMP(LCMP obj); // opcode = 148

    void visitFCMPL(FCMPL obj);

    void visitFCMPG(FCMPG obj);

    void visitDCMPL(DCMPL obj);

    void visitDCMPG(DCMPG obj);
    // endregion

    // region opcode if
    void visitIFEQ(IFEQ obj); // opcode = 153

    void visitIFNE(IFNE obj);

    void visitIFLT(IFLT obj);

    void visitIFGE(IFGE obj);

    void visitIFGT(IFGT obj);

    void visitIFLE(IFLE obj);

    void visitIF_ICMPEQ(IF_ICMPEQ obj); // opcode = 159

    void visitIF_ICMPNE(IF_ICMPNE obj);

    void visitIF_ICMPLT(IF_ICMPLT obj);

    void visitIF_ICMPGE(IF_ICMPGE obj);

    void visitIF_ICMPGT(IF_ICMPGT obj);

    void visitIF_ICMPLE(IF_ICMPLE obj);

    void visitIF_ACMPEQ(IF_ACMPEQ obj);

    void visitIF_ACMPNE(IF_ACMPNE obj);

    void visitIFNULL(IFNULL obj);

    void visitIFNONNULL(IFNONNULL obj);
    // endregion

    // region opcode branch
    void visitGOTO(GOTO obj); // opcode = 167

    void visitGOTO_W(GOTO_W obj); // opcode = 200

    void visitJSR(JSR obj); // opcode = 168

    void visitJSR_W(JSR_W obj);

    void visitRET(RET obj); // opcode = 169

    void visitTABLESWITCH(TABLESWITCH obj); // opcode = 170

    void visitLOOKUPSWITCH(LOOKUPSWITCH obj); // opcode = 171
    // endregion

    // region opcode return
    void visitIRETURN(IRETURN obj); // opcode = 172

    void visitLRETURN(LRETURN obj);

    void visitFRETURN(FRETURN obj);

    void visitDRETURN(DRETURN obj);

    void visitARETURN(ARETURN obj);

    void visitRETURN(RETURN obj);
    // endregion

    // region opcode c_field
    void visitGETSTATIC(GETSTATIC obj); // opcode = 178

    void visitPUTSTATIC(PUTSTATIC obj);

    void visitGETFIELD(GETFIELD obj);

    void visitPUTFIELD(PUTFIELD obj);
    // endregion

    // region opcode invoke
    void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj); // opcode = 182

    void visitINVOKESPECIAL(INVOKESPECIAL obj);

    void visitINVOKESTATIC(INVOKESTATIC obj);

    void visitINVOKEINTERFACE(INVOKEINTERFACE obj);

    void visitINVOKEDYNAMIC(INVOKEDYNAMIC obj);
    // endregion

    // region opcode allocate
    void visitNEW(NEW obj); // opcode = 187

    void visitNEWARRAY(NEWARRAY obj);

    void visitANEWARRAY(ANEWARRAY obj);

    void visitARRAYLENGTH(ARRAYLENGTH obj);

    void visitMULTIANEWARRAY(MULTIANEWARRAY obj); // opcode = 197
    // endregion

    // region opcode xxx
    void visitATHROW(ATHROW obj); // opcode = 191

    void visitCHECKCAST(CHECKCAST obj);

    void visitINSTANCEOF(INSTANCEOF obj);

    void visitMONITORENTER(MONITORENTER obj);

    void visitMONITOREXIT(MONITOREXIT obj);

    void visitWIDE(WIDE obj);

    void visitBREAKPOINT(BREAKPOINT obj);

    void visitIMPDEP1(IMPDEP1 obj);

    void visitIMPDEP2(IMPDEP2 obj);
    // endregion

}
