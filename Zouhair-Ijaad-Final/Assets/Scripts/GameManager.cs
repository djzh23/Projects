using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;
using UnityEngine.SceneManagement;

/* Class */
public class ValueChangedEvent: UnityEvent < string,int > {};
/* **** */ 

public class GameManager: MonoBehaviour {
	public static int gesammelteCoins = 0;
	public static int anzahlLifes = 3;

	public bool extraLife = false;
	public bool runterfallen = false;
	public static int anzahlRunterFallen;
	public bool dead = false;
	public bool won = false;

	public bool end = false;

	public bool camChanged = false;
	private Camera cam2;
	private Camera cam1;
	public bool cam1Active = true;
	public ValueChangedEvent valueChanged;

	// Start is called before the first frame update
	private void Start() {

		valueChanged = new ValueChangedEvent();
		Time.timeScale = 1f;
		cam2 = GameObject.Find("MoveCamera").GetComponent < Camera > ();
		cam2.enabled = false;
		cam1 = Camera.main;

	}

	private void Update() {
		ChangeCamera();
	}

	public int GetValue(string name) {
		switch (name) {

		case "anzahlCoins":
			return gesammelteCoins;
		case "anzahlLifes":
			return anzahlLifes;
		default:
			return - 1;
		}
	}

	// Camera changing
	public void ChangeCamera() {
		if (Input.GetKeyDown("c")) {
			camChanged = true;
			cam1Active = !cam1Active;
			cam1.enabled = !cam1.enabled;
			cam2.enabled = !cam2.enabled;

		}
	}

	public void CountCoins() {
		gesammelteCoins++;
		int anzahlCoins = GetValue("anzahlCoins");
		valueChanged.Invoke("anzahlCoins", anzahlCoins);
	}
	public void CountExtraLive() {
		anzahlLifes++;
		extraLife = true;
		int anzahlCoins = GetValue("anzahlCoins");
		valueChanged.Invoke("anzahlLifes", anzahlLifes);
	}

	public void LivesCounter() {
		anzahlLifes -= 1;
		valueChanged.Invoke("anzahlLifes", anzahlLifes);
		if (anzahlLifes <= 0) {
			dead = true;
		}
	}

	// Level 1 - Scene
	public void startGame() {
		Time.timeScale = 1f;
		SceneManager.LoadScene(1);
		anzahlLifes = 3;
	}

	// Credit Scene
	public void CreditGame() {
		SceneManager.LoadScene(4);
	}

	// Menu Scene
	public void MenuScene() {
		gesammelteCoins = 0;
		anzahlLifes = 3;
		Time.timeScale = 1f;
		SceneManager.LoadScene(0);
	}

	//  Play Again Scene 
	public void PlayAgainScene() {
		Time.timeScale = 1f;
		SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);

		gesammelteCoins = 0;
		runterfallen = false;
	}

	// Try Again after Game Over
	public void PlayAfterGameOver() {
		anzahlLifes = 3;
		anzahlRunterFallen = 0;
		gesammelteCoins = 0;
		dead = false;
		runterfallen = false;
		Time.timeScale = 1f;
		SceneManager.LoadScene(1);
	}

	// Next Level
	public void NextLevel() {
		runterfallen = false;
		Time.timeScale = 1f;
		SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
	}
	public void EndScene() {
		Time.timeScale = 1f;
		SceneManager.LoadScene(5);
	}

	// Exit Game
	public void ExitGame() {
		Application.Quit();
	}
}