package Final;

import java.util.Scanner;

public class GameManager {
	//Singleton
    private static GameManager instance = new GameManager();
    private Scanner scanner = new Scanner(System.in);
    private Character playerCharacter;
    public Character getPlayerCharacter() {
		return playerCharacter;
	}

	public Character getEnemyCharacter() {
		return enemyCharacter;
	}

	private Character enemyCharacter;

    private GameManager() {
    }

    public static GameManager getInstance() {
        return instance;
    }

    public void init() {
    	 System.out.println("Seleccionando personaje");
         CharacterFactory playerFactory = selectCharacterFactory();
         playerCharacter = playerFactory.createCharacter();
         System.out.println("Has seleccionado: " + playerCharacter.getType());

         System.out.println("Seleccionando a un enemigo para enfrentar...");
         CharacterFactory enemyFactory = selectCharacterFactory();
         enemyCharacter = enemyFactory.createCharacter();
         System.out.println("Enemigo: " + enemyCharacter.getType());
    }
    
    public void startGame() {
        System.out.println("Bienvenido al juego de combate por turnos. PvE.");

        while (playerCharacter.getHealth() > 0 && enemyCharacter.getHealth() > 0) {
            playerTurn(playerCharacter, enemyCharacter);
            if (enemyCharacter.getHealth() > 0) {
                enemyTurn(playerCharacter, enemyCharacter);
            }
            playerCharacter.processTurn();
            enemyCharacter.processTurn();
        }

        endGame(playerCharacter, enemyCharacter);
    }


    private void playerTurn(Character player, Character enemy) {
        System.out.println("Tu turno. Elige una acción:");
        System.out.println("A - Atacar (ataque básico al enemigo)");
        System.out.println("E - Habilidad especial (utiliza la habilidad única de tu personaje)");
        System.out.println("H - Habilidad de curación");
        char action = scanner.next().charAt(0);

        switch (action) {
            case 'A':
            case 'a':
            	player.setStrategy(new AttackStrategy());
                break;
            case 'E':
            case 'e':
            	if (player instanceof Mage) {
                    player.setStrategy(new PoisonStrategy());
                } else if (player instanceof Warrior) {
                    player.setStrategy(new ArmorStrategy());
                }
                break;
            case 'H':
            case 'h':
            	if (player instanceof Mage) {
                    player.setStrategy(new HealingStrategy());
                }
                break;
            default:
                System.out.println("Acción no reconocida, turno perdido.");
                break;
        }
        
        player.action(enemy);
        enemy.defend();
    }

    private void enemyTurn(Character player, Character enemy) {
        System.out.println("Turno del enemigo. El enemigo ataca.");
        enemy.attack(player);
        player.defend();
    }

    private CharacterFactory selectCharacterFactory() {
        System.out.println("1. Mago de Fuego");
        System.out.println("2. Mago de Hielo");
        System.out.println("3. Guerrero con Espada");
        System.out.println("4. Guerrero con Escudo");
        System.out.print("Ingresa el número de tu elección: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new FireMageFactory();
            case 2:
                return new IceMageFactory();
            case 3:
                return new SwordWarriorFactory();
            case 4:
                return new ShieldWarriorFactory();
            default:
                System.out.println("Selección no válida, seleccionando Mago de Fuego por defecto.");
                return new FireMageFactory();
        }
    }

    public void endGame(Character player, Character enemy) {
        if (player.getHealth() > 0) {
            System.out.println("¡Has ganado el juego!");
        } else {
            System.out.println("Has perdido el juego.");
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
    	GameFacade gameFacade = new GameFacade();
        gameFacade.startGame();
    }
}
