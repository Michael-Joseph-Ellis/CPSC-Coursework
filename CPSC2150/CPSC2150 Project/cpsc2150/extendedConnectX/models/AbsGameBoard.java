package cpsc2150.extendedConnectX.models;

public abstract class AbsGameBoard implements IGameBoard 
{
    @Override
    public abstract String toString();

    public abstract IGameBoard makeBoard();
}