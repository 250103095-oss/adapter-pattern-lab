public class BulbAdapter implements SmartDevice {
    private final LegacyBulb bulb;

    @Override
    public void turnOn(){
        bulb.setBrightness(255);
    }
    @Override
    public void turnOff(){
        bulb.setBrightness(0);
    }
    @Override
    public boolean isOn(){
        if (bulb.hasPower()==true && bulb.readBrightness()>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public int getPowerPercent(){
        int raw = bulb.readBrightness();
        if (bulb.readBrightness()==0){
            return 0;
        }else{
            int base= (raw * 100)/255;
            int K = 5;
            int calibrated = base + K;
            if (calibrated >100){
                return 100;
            }else{
                return calibrated;
            }
        }
    }

    public BulbAdapter(LegacyBulb bulb) {
        if (bulb==null) {
            throw new IllegalArgumentException("Bulb argument is null");
        } this.bulb = bulb;
    }
}