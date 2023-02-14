package nl.han.dea;

public class FizzBuzzer {

    private FizzBuzzInputAndOutput fbIo;

    public FizzBuzzer(FizzBuzzInputAndOutput fbIo) {
        this.fbIo = fbIo;
    }

    public String fizzbuzz() {
        return "" + fbIo.getTeller();
    }
}
