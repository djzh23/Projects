using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DornController : MonoBehaviour
{

public GameManager gameManager;
private Vector3 startPosition;
public float delta = 1.5f;
public float speed = 2.0f;

void Start(){
    startPosition = transform.position;
}
void Update(){
    Vector3 dornPosition = startPosition;
    dornPosition.x += delta * Mathf.Sin(Time.time * speed);
    transform.position = dornPosition;
  }

public void OnCollisionEnter (Collision other){
        if (other.gameObject.tag == "ballTag"){   
            gameManager.LivesCounter();
        }
    }

}
