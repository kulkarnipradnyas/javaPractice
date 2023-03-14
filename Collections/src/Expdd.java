
class Amount	{
	public Amount(String	currency,	int amount)	{
					this.currency =	currency;
					this.amount =	amount;
	}
	String	currency;//	Should	be	an	Enum
	int amount;//	Should	ideally	use	BigDecimal
}
//AmountAdder	class	has	method	addAmounts	which	is	throwing	a	RuntimeException
class AmountAdder	{
	static Amount	addAmounts(Amount	amount1,	Amount	amount2)	throws Exception	{
		System.out.print(amount1.currency + "****");
					if (!amount1.currency.equals(amount2.currency))	{
									throw new Exception("Currencies	don't	match");
					}
					return new Amount(amount1.currency,	amount1.amount +	amount2.amount);
	}
}
public class Expdd	{
	public static void main(String[]	args) throws Exception	{
					AmountAdder.addAmounts(new Amount("RUPEE",	5),	new Amount("DOLLAR",	5));
	}
}