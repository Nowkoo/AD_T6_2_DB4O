import classesEmpleat.Empleat
import com.db4o.Db4oEmbedded


fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")
    val patro = Empleat("22222222b")
    val llista = bd.queryByExample<Empleat>(patro)

    if (llista.hasNext()) {
        val empleat = llista.next() as Empleat
        println(
            "Nif: ${empleat.nif}. Nom: ${empleat.nom}. Població: ${empleat.adreca?.poblacio}"
        )
        if (empleat.correus != null) {
            println("Primer correu: ${empleat.correus?.get(0)}")
        }

        if (empleat.telefons != null) {
            println("Primer telèfon: ${empleat.telefons?.get(0)?.numero}")
        }
    }

    bd.close()
}