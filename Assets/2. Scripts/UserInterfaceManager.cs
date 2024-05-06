using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UserInterfaceManager : MonoBehaviour
{

    // UI ����

    // UI ������Ʈ��  0 : hp / 1 : mp / 2 : stamina / 3 : gold / 4 : weapon
    public GameObject[] userInterfaceObjects;

    // UI �гε� 0 : �κ��丮 / 1 : ĳ���� ��ȭ / 2 : ���� ��ȭ / 3 : �Ͻ����� / 4 : ȯ�漳�� / 5 : ����â / 6 : ��ȭâ
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


    // UI ���� / 0 : hp / 1 : mp / 2 : stamina / 3 : gold
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

    // ���� UI ���� / 0 : �� / 1 : ���� / 2 : Ȱ / 3 : ������ / 4 : ������
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

        // !! ���� �κ��丮 ���� �ҷ�����
    }

    public void OpenReinforceCharacter()
    {
        userInterfacePanels[1].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(1);
        
        // !! ���� ��ȭ ���� �ҷ�����
    }

    public void OpenReinforceWeapon()
    {
        userInterfacePanels[2].SetActive(true);
        Time.timeScale = 0f;
        userInterfaceStack.Push(2);

        // !! ���� ��ȭ ���� �ҷ�����
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

        // !! ���� ���� ���� �ҷ�����
    }

    public void SetStatus()
    {
        // ����â ���� �ҷ�����
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

        // !! ��ȭ���� �ҷ�����
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
