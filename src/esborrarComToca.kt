import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded

fun main() {
    val conf = Db4oEmbedded.newConfiguration()
    conf.common().objectClass("classEmpleat.Empleat").cascadeOnDelete(true)
    val bd = Db4oEmbedded.openFile(conf, "Empleats.db")
    val patro = Empleat("11111111a")

    val llista = bd.queryByExample<Empleat>(patro)
    if (llista.hasNext()) {
        val empleat: Empleat = llista.next()
        bd.delete(empleat)
    }
    bd.close()
}