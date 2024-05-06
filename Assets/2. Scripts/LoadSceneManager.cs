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
        // !! ���� �ʱ�ȭ

        userInterfaceManager.OpenIngameUserInterface();
        SceneManager.LoadScene(1);
    }

    public void ContinueGame()
    {
        // !! �ҷ�����

        userInterfaceManager.OpenIngameUserInterface();
        SceneManager.LoadScene(1);
    }

    public void GoTitle()
    {
        SceneManager.LoadScene(0);
    }
}
