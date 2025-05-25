public class ConsumoEnergia {
    private double consumo;
    private static final double tarifa = 0.28172;

    public ConsumoEnergia(double consumo) {
        this.consumo = consumo;
    }

    public double calcularFornecimento() {
        return consumo * tarifa;
    }

    public double calcularICMS(double fornecimento) {
        double aliquota;
        if (consumo <= 200) {
            aliquota = 0.136363;
        } else {

            aliquota = 0.333333;
        }
        return fornecimento * aliquota;
    }

    public double calcularCOFINS(double fornecimento) {
        double aliquota;
        if (consumo <= 200) {
            aliquota = 0.0614722;
        } else {
            aliquota = 0.0730751;
        }
        return fornecimento * aliquota;
    }

    public double calcularPISPASEP(double fornecimento) {
        double aliquota;
        if (consumo <= 200) {
            aliquota = 0.013346;
        } else {
            aliquota = 0.0158651;
        }
        return fornecimento * aliquota;
    }

    public double calcularFatura() {
        double fornecimento = calcularFornecimento();
        double icms = calcularICMS(fornecimento);
        double cofins = calcularCOFINS(fornecimento);
        double pisPasep = calcularPISPASEP(fornecimento);

        double icmsCofins, icmsPisPasep;
        if (consumo <= 200) {
            icmsCofins = cofins * 0.136363;
            icmsPisPasep = pisPasep * 0.136363;
        } else {
            icmsCofins = cofins * 0.333333;
            icmsPisPasep = pisPasep * 0.333333;
        }

        return fornecimento + icms + cofins + pisPasep + icmsCofins + icmsPisPasep;
    }

    public void exibirDetalhes() {
        double fornecimento = calcularFornecimento();
        double icms = calcularICMS(fornecimento);
        double cofins = calcularCOFINS(fornecimento);
        double pisPasep = calcularPISPASEP(fornecimento);

        double icmsCofins, icmsPisPasep;
        if (consumo <= 200) {
            icmsCofins = cofins * 0.136363;
            icmsPisPasep = pisPasep * 0.136363;
        } else {
            icmsCofins = cofins * 0.333333;
            icmsPisPasep = pisPasep * 0.333333;
        }

        double fatura = calcularFatura();

        System.out.println(" Fornecimento = " + fornecimento +
                "\n ICMS = " + icms +
                "\n COFINS = " + cofins +
                "\n PIS/PASEP = " + pisPasep +
                "\n ICMS SOBRE COFINS = " + icmsCofins +
                "\n ICMS SOBRE PIS/PASEP = " + icmsPisPasep +
                "\n FATURA = " + fatura);
    }
}
