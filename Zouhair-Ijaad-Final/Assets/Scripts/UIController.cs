using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UIController : MonoBehaviour
{
    
    public GameManager gameManager;

    public GameObject runterFallenMenuUI;
    public GameObject gameOverMenuUI;
    public GameObject WonUI;
   
    // Update is called once per frame

    void Update(){

        if(gameManager.runterfallen == true){
            if(GameManager.anzahlRunterFallen == 3 && !gameManager.extraLife){
                gameOverMenuUI.SetActive(true);
                Time.timeScale = 0f;
            }else{
                runterFallenMenuUI.SetActive(true);
                Time.timeScale = 0f;
        
            }
                }

        if(gameManager.dead == true && gameManager.runterfallen == true){
            gameOverMenuUI.SetActive(true);
            Time.timeScale = 0f;
        }

        if(gameManager.won == true){
            WonUI.SetActive(true);
            Time.timeScale = 0f;
        }

    }
}
