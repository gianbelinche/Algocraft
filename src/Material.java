public interface Material {

    public Material recoger(Material material, int desgaste);

    public Material recoger(Piedra   material, int desgaste);

    public Material recoger(Madera   material, int desgaste);
}