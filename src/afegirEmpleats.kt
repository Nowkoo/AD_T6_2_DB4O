import classesEmpleat.Adreca
import classesEmpleat.Empleat
import classesEmpleat.Telefon
import com.db4o.Db4oEmbedded

fun main() {
    val bd = Db4oEmbedded.openFile("Empleats.db")
    var empleat1 = Empleat("11111111a")
    empleat1.adreca = Adreca("C/ Major, 7", "12001", "Castelló")
    empleat1.correus = arrayOf("alu11111111a@ieselcaminas.org")
    empleat1.telefons = arrayOf(Telefon(true, "666777888"), Telefon(false, "964555222"))

    var empleat2 = Empleat("22222222b", "Berta", "10", 35, 1700.0)
    empleat2.adreca = Adreca("C/ Enmig, 7", "12001", "Castelló")
    empleat2.correus = arrayOf("alu22222222b@ieselcaminas.org", "berta@gmail.com")
    empleat2.telefons = arrayOf(Telefon(true, "666555444"), Telefon(false, "964223344"))

    var empleat3 = Empleat("33333333c", "Berta", "10", 35, 1700.0)
    empleat3.adreca = Adreca("C/ de Dalt, 7", "12530", "Borriana")
    empleat3.correus = arrayOf("alu33333333c@ieselcaminas.org")

    bd.store(empleat1)
    bd.store(empleat2)
    bd.store(empleat3)
    bd.close()
}