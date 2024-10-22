package Final;

public class GameFacade {
    private GameManager gameManager;

    public GameFacade() {
        this.gameManager = GameManager.getInstance();
    }

    public void startGame() { 
    	gameManager.init();
        gameManager.startGame();       // Comienza el flujo del juego
    }

    public void endGame() {
        gameManager.endGame(gameManager.getPlayerCharacter(), gameManager.getEnemyCharacter());
    }
}
