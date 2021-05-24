using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WonController : MonoBehaviour
{
    public GameManager gameManager;
    public GameObject WonUI;
    // Update is called once per frame
    void Update()
    {
        if(gameManager.won == true){
           //gameManager.NextLevel();
           WonUI.SetActive(true);
            //Time.timeScale = 0f;
        }
    }
}
