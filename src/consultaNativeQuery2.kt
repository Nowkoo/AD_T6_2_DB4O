import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded
import com.db4o.query.Predicate

fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")
    val max = 1800.0
    val min = 1000.0
    val llista = bd.query(object: Predicate<Empleat>() {
        override
        fun match(emp: Empleat): Boolean {
            if(emp.sou!! <= max && emp.sou!! >= min)
                return true
            else
                return false
        }
    })

    for (e in llista) {
        println("${e.nom} (${e.adreca?.poblacio})")
    }
    bd.close()
}