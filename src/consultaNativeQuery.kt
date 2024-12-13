import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded
import com.db4o.query.Predicate

class EmpleatsPerPoblacio(pobles: Array<String>): Predicate<Empleat>() {
    val poblacions = pobles

    override fun match(emp: Empleat): Boolean {
        return (emp.adreca?.poblacio in poblacions)
    }
}

fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")
    val pobl = arrayOf("Castelló", "Borriana")

    val llista = bd.query(EmpleatsPerPoblacio(pobl))

    for (e in llista) {
        println("${e.nom} (${e.adreca?.poblacio})")
    }
    bd.close()
}