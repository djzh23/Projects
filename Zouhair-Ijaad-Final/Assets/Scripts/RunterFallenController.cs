using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RunterFallenController : MonoBehaviour
{
    public GameObject runterFallenUI;
    public GameManager gameManager;

    
    void Update()
    {
        if(gameManager.runterfallen && gameManager.runterfallen){
            runterFallenUI.SetActive(true);
            Time.timeScale = 0f;
        }
        
    }
}
