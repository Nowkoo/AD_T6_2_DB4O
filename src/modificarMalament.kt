import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded

fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")

    val patro = Empleat("22222222b")
    val llista = bd.queryByExample<Empleat>(patro)

    if (llista.hasNext()) {
        var empleat = llista.next()
        if (empleat.sou != null) {
            empleat.sou = empleat.sou!! + 200
        }
        val adreca = empleat.adreca
        adreca?.carrer = "Pl. Rei en Jaume, 15"
        adreca?.codipostal = "12002"
        empleat.adreca = adreca

        bd.store(empleat)
    }

    bd.close()
}