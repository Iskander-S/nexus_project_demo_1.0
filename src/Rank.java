public enum Rank {
    E_RANK("E-Rank"),
    D_RANK("D-Rank"),
    C_RANK("C-Rank"),
    B_RANK("B-Rank"),
    A_RANK("A-Rank"),
    S_RANK("S-Rank");

    private final String displayName;

    Rank(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}