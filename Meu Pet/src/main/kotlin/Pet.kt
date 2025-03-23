class Pet {
    var idade: Int = 5
        private set // A idade só pode ser alterada internamente

    var nome: String = "keyle"
        private set // O nome só pode ser alterado internamente

    var fome: Int = 6
        get() = field.coerceIn(0, 9) // Garante que fome esteja entre 0 e 9

    var felicidade: Int = 8
        get() = field.coerceIn(1, 10) // Garante que felicidade esteja entre 1 e 10

    var cansaco: Int = 0
        get() = field.coerceIn(0, 9) // Garante que cansaco esteja entre 0 e 9

    var vontadeDeIrAoBanheiro: Boolean = false
        private set // Só pode ser alterado internamente

    var sujeira: Int = 5
        get() = field.coerceIn(0, 9) // Garante que sujeira esteja entre 0 e 9

    var tempoEmSegundos: Int = 1000
        private set // Só pode ser alterado internamente

    var chamadasAlimentar: Int = 0
        private set // Só pode ser alterado internamente

    var chamadasBrincar: Int = 0
        private set // Só pode ser alterado internamente

    // Função para verificar se o jogador perdeu
    fun verificarSePerdeu(): Boolean {
        return cansaco == 10 || fome == 10 || sujeira == 10 || felicidade == 0
    }

    // Função para incrementar a idade com base no tempo decorrido
    fun incrementarIdade() {
            Thread.sleep(1000)
            idade++
    }

    // Função para alimentar o pet
    fun alimentarPet() {
        if (chamadasAlimentar % 4 == 0) {
            cansaco++
        }
        fome--
        chamadasAlimentar++
    }

    // Função para brincar com o pet
    fun brincarComPet() {
        if (chamadasBrincar % 4 == 0) {
            sujeira++
        }
        felicidade++
        cansaco++
        chamadasBrincar++
    }

    // Função para descansar o pet
    fun descansarPet() {
        if (cansaco < 10) {
            Thread.sleep(1000) // Aguarda 1 segundo (1000 ms)
            cansaco--
        }
    }

    // Função para verificar o status do pet
    fun verificarStatus(){
        println("Fome: $fome, Felicidade: $felicidade, Sujeira: $sujeira, Cansaso, $cansaco, idade $idade")
    }

    // Função para informar o tempo necessário para descansar
    fun informarDescanso() {
        val tempoParaDescansar = cansaco // considera 1 segundo por cansado
        println("O tempo total para o descanso é $tempoParaDescansar S")
    }

    // Função principal (início do programa)
    fun iniciar() {
        while (true){
        if (verificarSePerdeu()) {
            println("Você perdeu")
            return
        }

        incrementarIdade()
        verificarStatus()
    }
    }
}