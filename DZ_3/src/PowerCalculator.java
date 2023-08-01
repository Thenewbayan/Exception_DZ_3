class PowerCalculator {
    public PowerCalculator() {
    }

    
    /**создаем метод для вычисления степени, если выполняется условие для значений <1 и =0, 
     * то выбрасывается исключение InvalidInputException, которое мы создали
     * @param base основание
     * @param exponent показатель степени
     * @return
     * @throws InvalidInputException класс исключений некореткного ввода
     */
    public double calculatePower(double base, double exponent) throws InvalidInputException {
        if (base == 0 || exponent < 1) {
            throw new InvalidInputException("Некоректные значения показателя степени");
        }
        return Math.pow(base, exponent);
    }
    
}