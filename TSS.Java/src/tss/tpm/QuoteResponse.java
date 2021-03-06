package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to quote PCR values.  */
public class QuoteResponse extends RespStructure
{
    /** The quoted information  */
    public TPMS_ATTEST quoted;
    
    /** Selector of the algorithm used to construct the signature  */
    public TPM_ALG_ID signatureSigAlg() { return signature != null ? signature.GetUnionSelector() : TPM_ALG_ID.NULL; }
    
    /** The signature over quoted  */
    public TPMU_SIGNATURE signature;
    
    public QuoteResponse() {}
    
    /** TpmMarshaller method  */
    @Override
    public void toTpm(TpmBuffer buf)
    {
        buf.writeSizedObj(quoted);
        buf.writeShort(signature.GetUnionSelector());
        signature.toTpm(buf);
    }
    
    /** TpmMarshaller method  */
    @Override
    public void initFromTpm(TpmBuffer buf)
    {
        quoted = buf.createSizedObj(TPMS_ATTEST.class);
        TPM_ALG_ID signatureSigAlg = TPM_ALG_ID.fromTpm(buf);
        signature = UnionFactory.create("TPMU_SIGNATURE", signatureSigAlg);
        signature.initFromTpm(buf);
    }
    
    /** @deprecated Use {@link #toBytes()} instead  */
    public byte[] toTpm () { return toBytes(); }
    
    /** Static marshaling helper  */
    public static QuoteResponse fromBytes (byte[] byteBuf) 
    {
        return new TpmBuffer(byteBuf).createObj(QuoteResponse.class);
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static QuoteResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    /** Static marshaling helper  */
    public static QuoteResponse fromTpm (TpmBuffer buf) 
    {
        return buf.createObj(QuoteResponse.class);
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_Quote_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_ATTEST", "quoted", quoted);
        _p.add(d, "TPMU_SIGNATURE", "signature", signature);
    }

    @Override
    public SessEncInfo sessEncInfo() { return new SessEncInfo(2, 1); }
}

//<<<
