using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Speedy : MonoBehaviour
{
    GameManager gameManager;
    // Start is called before the first frame update
    public BallController ballController;
     private void OnTriggerEnter(Collider other){
        if(other.gameObject.CompareTag("ballTag")){
          ballController.speed *= 3;
        }
     }
      private void OnTriggerExit(Collider other){
          ballController.speed = 400;
        }

}
