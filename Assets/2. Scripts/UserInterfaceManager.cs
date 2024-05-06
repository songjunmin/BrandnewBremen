using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UserInterfaceManager : MonoBehaviour
{

    // UI 관련

    // UI 오브젝트들  0 : hp / 1 : mp / 2 : stamina / 3 : gold / 4 : weapon
    public GameObject[] userInterfaceObjects;

    // UI 패널들 0 : 인벤토리 / 1 : 캐릭터 강화 / 2 : 무기 강화 / 3 : 일시정지 / 4 : 환경설정 / 5 : 상태창 / 6 : 대화창
    public GameObject[] userInterfacePanels;

    public GameObject ingameUserInterface;

    Stack<int> userInterfaceStack = new Stack<int>();


    //    PlayerStatus playerStatus;


    private void Start()
    {
        // playerStatus = GameManager.instance.getComponent<PlayerStatus>();
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            EscapeUserInterface();
        }

        else if (Input.GetKeyDown(KeyCode.I))
        {
            OpenStatus();
        }
    }


    // UI 갱신 / 0 : hp / 1 : mp / 2 : stamina / 3 : gold
    public void RenewUserInterface(int userInterfaceType)
    {
        switch (userInterfaceType)
        {
            case 0:
                // userInterfaceObjects[0].GetComponent<Text>().text = player.getComponent<PlayerStatus>().healthPoint;
                break;
            case 1:
                // userInterfaceObjects[1].GetComponent<Text>().text = player.getComponent<PlayerStatus>().manaPoint;
                break;
            case 2:
                // userInterfaceObjects[2].GetComponent<Text>().text = player.getComponent<PlayerStatus>().stemina;
                break;
            case 3:
                // userInterfaceObjects[3].GetComponent<Text>().text = GameManager.instance.gold.ToString();
                break;

        }
    }

    // 무기 UI 변경 / 0 : 검 / 1 : 도끼 / 2 : 활 / 3 : 지팡이 / 4 : 마법서
    public void ChangeWeapon(int weaponType)
    {
        switch (weaponType)
        {
            case 0:
                // userInterfaceObjects[4].getComponent<Image>().image = Resources.load("Sword");
                break;
            case 1:
                // userInterfaceObjects[4].getComponent<Image>().image = Resources.load("Ax");
                break;
            case 2:
                // userInterfaceObjects[4].getComponent<Image>().image = Resources.load("Bow");
                break;
            case 3:
                // userInterfaceObjects[4].getComponent<Image>().image = Resources.load("Cane");
                break;
            case 4:
                // userInterfaceObjects[4].getComponent<Image>().image = Resources.load("MagicBook");
                break;
        }
    }

    public void OpenInventory()
    {
        userInterfacePanels[0].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(0);

        // !! 현재 인벤토리 내용 불러오기
    }

    public void OpenReinforceCharacter()
    {
        userInterfacePanels[1].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(1);
        
        // !! 현재 강화 내용 불러오기
    }

    public void OpenReinforceWeapon()
    {
        userInterfacePanels[2].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(2);

        // !! 현재 강화 내용 불러오기
    }

    public void OpenPause()
    {
        userInterfacePanels[3].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(3);
    }

    public void OpenSetting()
    {
        userInterfacePanels[4].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(4);

        // !! 현재 세팅 내용 불러오기
    }

    public void SetStatus()
    {
        // 상태창 내용 불러오기
        Transform contentsText = userInterfacePanels[5].transform.GetChild(0);
        //        contentsText.GetChild(0).GetComponent<Text>().text = playerStatus.healthPoint.toString() + " / " + playerStatus.maxHealthPoint.toString();
        //        contentsText.GetChild(1).GetComponent<Text>().text = playerStatus.manaPoint.toString() + " / " + playerStatus.maxManaPoint.toString();
        //        contentsText.GetChild(2).GetComponent<Text>().text = playerStatus.stemina.toString() + " / " + playerStatus.maxStemina.toString();
        //        contentsText.GetChild(3).GetComponent<Text>().text = playerStatus.attackPower.toString();
        //        contentsText.GetChild(4).GetComponent<Text>().text = playerStatus.magicPower.toString();

    }

    public void OpenStatus()
    {
        userInterfacePanels[5].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(5);

        SetStatus();
    }

    public void OpenConversation()
    {
        userInterfacePanels[6].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(6);

        // !! 대화내용 불러오기
    }

    public void OpenIngameUserInterface()
    {
        ingameUserInterface.SetActive(true);
    }

    public void EscapeUserInterface()
    {
        if (userInterfaceStack.Count == 0)
        {
            OpenPause();
        }
        else
        {
            if (userInterfaceStack.Count == 1)
            {
                Time.timeScale = 1f;
            }

            userInterfacePanels[userInterfaceStack.Pop()].SetActive(false);
        }
    }
}
