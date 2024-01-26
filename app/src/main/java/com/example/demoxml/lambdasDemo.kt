package com.example.demoxml

import android.content.Context


class Person(var name:String, var age: Int)



//necesito el contexto de una activity (this)
fun testLambdas(context: Context): Unit{
    var person = Person("Alice", 30)
    println("nombre original: ${person.name}")

    /*
    llamas a la funcion de extension creada para T (puede ser person) y ahi se hace uso de la
    lambda que estas mandando, la lambda no devuelve nada pero la funcion devuelve el mismo tipo
    que la llama
     */
    val resApply: Person = person.apply2 {
        it.name = "cambio"
    }

    println("nombre de la clase despues de apply: ${person.name}")
    println("nombre de la respuesta de apply: ${resApply.name}")



    person = Person("Alice", 30)
    println("\nnombre original: ${person.name}")

    /*
    aqui se llama a la funcion y se utiliza la lambda que se pasa, en este caso devuelve algo -> U
    que seria en este caso un String, en la lambda se esta utilizando la info de la clase
    que llama a la funcion
     */
    val resRun = person.run2 {
        val newName = it.name + "nuevo"
        "Nuevo nombrezzzxxx: $newName"
    }
    println("nombre de la clase despues de run: ${person.name}")
    println("nombre de la respuesta de run: ${resRun}")

    val resultado: String = person.let2 { persona ->
        "Nombre: ${persona.name}, Edad: ${persona.age}"
    }

//        val resultado: String = Person("Alice", 30).let2 {
//            "Nombre: ${name}, Edad: ${age}"
//        }

    context.toast(resApply.age.toString())

//        print("Resultadoo $resultado")

}



//fun <T> T.apply2(body: T.() -> Unit): T{
//    this.body()
//    return this
//}

fun <T> T.apply2(body: (T) -> Unit): T{
    body(this)
    return this
}

fun <T, U> T.run2(body: (T) -> U): U{
    return body(this)
}

fun <T, U> T.run3(body: T.() -> U): U{
    return this.body()
}


fun <T, U> T.let2(body: (T) -> U): U{
    return body(this)
//    return this.body()
}

fun <T, U> whith(reciver: T, body: T.() -> U): U{
    return reciver.body()
}

fun <T> T.also2(body: (T) -> Unit): T{
    body(this)
    return this
}
