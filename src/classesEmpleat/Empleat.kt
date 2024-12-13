package classesEmpleat

class Empleat(
    var nif: String? = null,
    var nom: String? = null,
    var departament: String? = null,
    var edat: Int? = null,
    var sou: Double? = null,
    var foto: ByteArray? = null,
    var curriculum: CharArray? = null,
    var adreca: Adreca? = null,
    var correus: Array<String>? = null,
    var telefons: Array<Telefon>? = null
) {
    constructor(nif: String) : this(
        nif = nif,
        nom = null,
        departament = null,
        edat = null,
        sou = null,
        foto = null,
        curriculum = null,
        adreca = null,
        correus = null,
        telefons = null,
    )
}
