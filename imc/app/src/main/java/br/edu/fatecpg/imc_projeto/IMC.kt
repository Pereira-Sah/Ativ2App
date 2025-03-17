package br.edu.fatecpg.imc_projeto

class IMC(val peso: Float, val altura: Float) {

    fun calcular(): Float {
        return peso / (altura * altura)
    }

    fun imc_classificacao(imc: Float): String {
        return if (imc < 18.5) {
            "Cuidado! Você está abaixo do peso!"
        } else if (imc < 24.9) {
            "Você está no peso ideal!"
        } else if (imc < 29.9) {
            "Cuidado! Você está com sobrepeso!"
        } else {
            "Cuidado! Você está com obesidade severa!"
        }
    }
}
