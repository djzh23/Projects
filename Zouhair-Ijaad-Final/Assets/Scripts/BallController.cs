using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEditor;

public class BallController: MonoBehaviour {

	private GameManager gameManager;
	public float speed;
	private float jumpForce = 3;
	private Rigidbody rb;
	private bool beeintraechtigt = false;
	private bool ballamboden = true;
	private Camera cam;
	void Start() {
		rb = GetComponent < Rigidbody > ();
		gameManager = GameObject.Find("Game Manager").GetComponent < GameManager > ();
	}
	void Awake() {
		this.cam = GameObject.Find("MoveCamera").GetComponent < Camera > ();
	}

	void Update() {

		float moveHorizontal = Input.GetAxis("Horizontal") * Time.deltaTime;
		float moveVertical = Input.GetAxis("Vertical") * Time.deltaTime;

		if (!beeintraechtigt && !gameManager.camChanged) {
			Vector3 move = new Vector3(moveHorizontal, 0.0f, moveVertical);
			rb.AddForce(move * speed);
		}

		if (gameManager.camChanged) {
			Vector3 moveX = cam.transform.right * moveHorizontal;
			Vector3 moveZ = cam.transform.forward * moveVertical;
			Vector3 move = moveX + moveZ;
			rb.AddForce(move * speed);
		}

		// das Ball lässt sich nur kotrollieren wenn es dem Boden berührt 
		if (Input.GetKeyDown(KeyCode.Space) && ballamboden) {
			rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);
			ballamboden = false;
		}
		// Lava Berührung
		if (beeintraechtigt) {
			speed = speed / 10;
		}
	}

	private void OnTriggerEnter(Collider other) {
		if (other.gameObject.CompareTag("coinTag")) {
			other.gameObject.SetActive(false);
			gameManager.CountCoins();
		}

		if (other.gameObject.CompareTag("extraLiveTag")) {
			other.gameObject.SetActive(false);
			gameManager.CountExtraLive();
		}

	}

	void OnCollisionEnter(Collision other) {
		if (other.gameObject.CompareTag("lavaTag")) {
			beeintraechtigt = true;
		}
		if (other.gameObject.CompareTag("arrivalTag")) {
			gameManager.won = true;

		}
		if (other.gameObject.tag == ("endCircleTag") || other.gameObject.tag == ("plateTag") && !ballamboden) {
			ballamboden = true;
		}
		if (other.gameObject.CompareTag("lastPlat")) {
			gameManager.EndScene();
		}

	}
	void OnCollisionExit(Collision other) {
		beeintraechtigt = false;
		speed = 400;
	}

}