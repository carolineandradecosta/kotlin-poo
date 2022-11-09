// O Bytebank é um projeto em Kotlin que simula um banco de dados digital.
// Funcionalidades: Criar contas; Depositar e sacar dinheiro; Transferir dinheiro entre as contas

fun main(){
    println("Bem vindo ao Banco ByteBank")

    // criando a conta da Carol
    val contaCarol = Conta(titular = "Carol", numero = 1000)
    // criando a conta do Gael
    val contaGael = Conta(titular = "Gael", numero = 1001)
    // criando a conta da Mel
    val contaMel = Conta(titular = "Mel", numero = 1002)

    println("Depositando na conta da Carol")
    contaCarol.deposita(500.0)

    println("Depositando na conta do Gael")
    contaGael.deposita(300.0)

    println("Depositando na conta da Mel")
    contaMel.deposita(800.0)

    println(contaCarol.titular)
    println(contaCarol.numero)
    println(contaCarol.saldo)

    println(contaGael.titular)
    println(contaGael.numero)
    println(contaGael.saldo)

    println(contaMel.titular)
    println(contaMel.numero)
    println(contaMel.saldo)

    println("Depositando na conta da Carol")
    contaCarol.deposita(valor = 50.0)
    println(contaCarol.saldo)

    println("Depositando na conta do Gael")
    contaGael.deposita(valor = 30.0)
    println(contaGael.saldo)

    println("Sacando da conta da Mel")
    contaMel.saca(valor = 100.0)
    println(contaMel.saldo)

    println("Sacando da conta da Carol")
    contaCarol.saca(valor = 50.0)
    println(contaCarol.saldo)

    println("Saque em excesso na conta do Gael") // o saque não é realizado
    contaGael.saca(valor = 350.0)
    println(contaGael.saldo)

    println("Transferindo da conta da Mel para a conta da Carol")
    if(contaMel.transfere(destino = contaCarol, valor = 200.0)){
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println(contaMel.saldo)
    println(contaCarol.saldo)
}


class Conta(
    val titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double){
        if(valor > 0){
            this.saldo += valor
        }
    }

    fun saca(valor: Double){
        if(this.saldo >= valor){
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean{
        if(this.saldo > valor){
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}