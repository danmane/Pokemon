package Pokemon;

public enum Ability
{
    OMGWHATISTHIS("I don't even know...");

    private final String DESCRIPTION;

    Ability(String description)
    {
        DESCRIPTION = description;
        ordinal();
    }
}