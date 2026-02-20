public class Droplet {
    public int x, y, z, len;

    public Droplet(boolean randomizeY) {
        if (randomizeY) y = (int) (Math.random() * RainSim.HEIGHT);
        else y = 0;
        x = (int) (Math.random() * RainSim.WIDTH);
        z = (int) (Math.random() * 99 + 1); // Range 1 - 100
        len = (int) (-5 / 33.0 * z + 665.0 / 33.0); // Range 20 - 5
    }
}
