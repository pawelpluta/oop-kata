package com.lynxted.sample;

class WashingController {

    private final Cleaner cleaner;

    WashingController(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    void washWool() {
        Basket laundryBasket = getLaundryBasket();
        cleaner.doLaundry(laundryBasket::takeOutWool, Programme::forWool);
    }

    void washCotton() {
        Basket laundryBasket = getLaundryBasket();
        cleaner.doLaundry(laundryBasket::takeOutCotton, Programme::forCotton);
    }

    void washSilk() {
        Basket laundryBasket = getLaundryBasket();
        cleaner.doLaundry(laundryBasket::takeOutSilk, Programme::forSilk);
    }

    private Basket getLaundryBasket() {
        Basket laundryBasket = Basket.empty();
        // fill the laundryBasket with available laundry by any way, e.g. obtaining it from repositories, providers, services
        return laundryBasket;
    }

}
