package utilz;

public class Constants {

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
		
	}
	
	public static class PlayerConstants{
		public static final int IDLE = 0;
		public static final int RUNNING = 1;

		
		
		public static int GetSpriteAmount(int player_action) {
			switch(player_action) {
			case 0:
				return 12;
			case 1:
				return 12;
			default:
				return 0;
			}
			
		}
	}
}
