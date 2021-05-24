using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ammu: MonoBehaviour {
	
	public float speed;
	private Transform ball;
	private Vector3 target;

	GameManager gameManager;
	void Start() {
		ball = GameObject.FindGameObjectWithTag("ballTag").transform;
		target = new Vector3(ball.position.x, ball.position.y, ball.position.z);
		gameManager = FindObjectOfType < GameManager > ();
	}

	private void Update() {
		transform.position = Vector3.MoveTowards(transform.position, target, speed * Time.deltaTime);
		Destroy(gameObject, 1);

		if (transform.position.x == target.x && transform.position.x == target.y && transform.position.x == target.z) {
			Destroy(gameObject, 1);

		}
	}

	private void OnCollisionEnter(Collision other) {
		if (other.gameObject.tag == "ballTag") {
			gameManager.LivesCounter();
			Destroy(gameObject, 1);

		}
	}

}