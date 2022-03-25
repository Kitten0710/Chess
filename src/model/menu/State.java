package model.menu;

public class State {

	public static enum STATE{
		MENU,
		GAME,
	}
	public static STATE State = STATE.MENU;
	
	public static STATE getState() {
		return State;
	}
	public static void setState(STATE state) {
		State = state;
	}

	
}
