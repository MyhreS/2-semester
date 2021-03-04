public class CamelCaseFormaterer implements Formaterer {

    @Override
    public String formater(String tekstSomSkalFormateres) {
        StringBuilder stringBygger = new StringBuilder();

        for (String ord : tekstSomSkalFormateres.split(" ")) {
            stringBygger.append(ord.substring(0, 1).toUpperCase());

            stringBygger.append(ord.substring(1).toLowerCase());

            stringBygger.append(" ");
        }

        return stringBygger.toString();
    }
}
