import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded

fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")
    val patro = Empleat("")

    val llista = bd.queryByExample<Empleat>(patro)
    if (llista.hasNext()) {
        val empleat: Empleat = llista.next()
        bd.delete(empleat)
    }
    bd.close()
}