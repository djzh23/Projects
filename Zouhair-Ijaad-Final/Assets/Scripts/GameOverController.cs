using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameOverController : MonoBehaviour
{
    public GameManager gameManager;
    public GameObject GameOverUI;

    // Update is called once per frame
    void Update()
    {
        if(gameManager.dead == true){
            GameOverUI.SetActive(true);
            Time.timeScale = 0f;
        }
    }
}
