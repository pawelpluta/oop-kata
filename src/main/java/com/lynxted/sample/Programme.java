package com.lynxted.sample;

abstract class Programme {

    private final Temperature temperature;
    private final SpinSpeed spinSpeed;

    Programme(Temperature temperature, SpinSpeed spinSpeed) {
        this.temperature = isValid(temperature) ? temperature : maximumTemperature();
        this.spinSpeed = isValid(spinSpeed) ? spinSpeed : maximumSpinSpeed();
    }

    static Programme forWool() {
        return new WoolProgramme();
    }

    static Programme forCotton() {
        return new CottonProgramme();
    }

    static Programme forSilk() {
        return new SilkProgramme();
    }

    Programme adjustTemperature(Temperature temperature) {
        return programmeFor(temperature, spinSpeed);
    }

    Programme adjustSpinSpeed(SpinSpeed spinSpeed) {
        return programmeFor(temperature, spinSpeed);
    }

    protected boolean isValid(Temperature temperature) {
        return temperature.isOverFreezingPoint() && temperature.isLowerOrEqual(maximumTemperature());
    }

    protected boolean isValid(SpinSpeed spinSpeed) {
        return spinSpeed.isLowerOrEqual(maximumSpinSpeed());
    }

    protected abstract Temperature maximumTemperature();
    protected abstract SpinSpeed maximumSpinSpeed();
    protected abstract Programme programmeFor(Temperature temperature, SpinSpeed spinSpeed);

    Temperature getTemperature() {
        return temperature;
    }

    SpinSpeed getSpinSpeed() {
        return spinSpeed;
    }

    private static class WoolProgramme extends Programme {

        private static final Temperature MAX_TEMERATURE = Temperature.celsius(40);
        public static final SpinSpeed MAX_SPIN_SPEED = SpinSpeed.forRpm(400);

        private WoolProgramme() {
            this(MAX_TEMERATURE, MAX_SPIN_SPEED);
        }

        private WoolProgramme(Temperature temperature, SpinSpeed spinSpeed) {
            super(temperature, spinSpeed);
        }

        @Override
        protected Temperature maximumTemperature() {
            return MAX_TEMERATURE;
        }

        @Override
        protected SpinSpeed maximumSpinSpeed() {
            return MAX_SPIN_SPEED;
        }

        @Override
        protected Programme programmeFor(Temperature temperature, SpinSpeed spinSpeed) {
            return new WoolProgramme(temperature, spinSpeed);
        }
    }

    private static class CottonProgramme extends Programme {

        private static final Temperature MAX_TEMERATURE = Temperature.celsius(95);
        public static final SpinSpeed MAX_SPIN_SPEED = SpinSpeed.forRpm(1200);

        private CottonProgramme() {
            this(MAX_TEMERATURE, MAX_SPIN_SPEED);
        }

        private CottonProgramme(Temperature temperature, SpinSpeed spinSpeed) {
            super(temperature, spinSpeed);
        }

        @Override
        protected Temperature maximumTemperature() {
            return MAX_TEMERATURE;
        }

        @Override
        protected SpinSpeed maximumSpinSpeed() {
            return MAX_SPIN_SPEED;
        }

        @Override
        protected Programme programmeFor(Temperature temperature, SpinSpeed spinSpeed) {
            return new CottonProgramme(temperature, spinSpeed);
        }
    }

    private static class SilkProgramme extends Programme {

        private static final Temperature MAX_TEMERATURE = Temperature.celsius(30);
        public static final SpinSpeed MAX_SPIN_SPEED = SpinSpeed.forRpm(300);

        private SilkProgramme() {
            this(MAX_TEMERATURE, MAX_SPIN_SPEED);
        }

        private SilkProgramme(Temperature temperature, SpinSpeed spinSpeed) {
            super(temperature, spinSpeed);
        }

        @Override
        protected Temperature maximumTemperature() {
            return MAX_TEMERATURE;
        }

        @Override
        protected SpinSpeed maximumSpinSpeed() {
            return MAX_SPIN_SPEED;
        }

        @Override
        protected Programme programmeFor(Temperature temperature, SpinSpeed spinSpeed) {
            return new SilkProgramme(temperature, spinSpeed);
        }
    }
}
