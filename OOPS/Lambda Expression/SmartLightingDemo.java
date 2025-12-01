import java.util.*;

public class SmartLightingDemo {
    public static void main(String[] args) {
        Light light = new Light();

        LightTrigger motionTrigger = () -> System.out.println("Motion detected: Turning on lights to 100% brightness");
        LightTrigger timeTrigger = () -> System.out.println("Evening time: Setting lights to warm dim mode");
        LightTrigger voiceTrigger = () -> System.out.println("Voice command received: Activating party mode lights");

        light.activate(motionTrigger);
        light.activate(timeTrigger);
        light.activate(voiceTrigger);
    }
}

interface LightTrigger {
    void trigger();
}

class Light {
    void activate(LightTrigger trigger) {
        trigger.trigger();
    }
}
