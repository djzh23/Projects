using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BodenController : MonoBehaviour
{
    public GameManager gameManager;


    private void OnCollisionEnter(Collision other){
        if(other.gameObject.CompareTag("ballTag")){
        gameManager.LivesCounter();
        gameManager.runterfallen = true;
        GameManager.anzahlRunterFallen++;
        }
    }

}
