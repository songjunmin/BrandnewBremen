using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class LoadSceneManager : MonoBehaviour
{
    UserInterfaceManager userInterfaceManager;

    private void Start()
    {
        userInterfaceManager = GetComponent<UserInterfaceManager>();        
    }

    public void NewGame()
    {
        // !! 내용 초기화

        userInterfaceManager.OpenIngameUserInterface();
        SceneManager.LoadScene(1);
    }

    public void ContinueGame()
    {
        // !! 불러오기

        userInterfaceManager.OpenIngameUserInterface();
        SceneManager.LoadScene(1);
    }

    public void GoTitle()
    {
        SceneManager.LoadScene(0);
    }
}
