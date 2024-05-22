//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lifeLabel: UILabel!
    
    var lifeCount : LifeCount?
    
    let opponentBall = OpponentBall(numberGenerator: RandomNumberGenerator())
    
    @IBOutlet weak var inputBall: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initBtn()
        initLifeLabel()
        
    }
    @IBAction func challengeBtn(_ sender: Any) {
        
        let inputText = inputBall.text
        do {
            let userNumbers = try UserBall(numbers: (inputText?.compactMap { Int(String($0)) })!)
            
            let referee = Referee()
            
            let resultScore = referee.getGameScore(baseNumbers: userNumbers.numbers, targetNumbers: [1,2,3])
            
            print(resultScore)
            
        } catch {
            print("잘못 입려하셨습니다.")
        }
        
        
        inputBall.text = ""
        if lifeCount!.decrease() {
            initLifeLabel()
        } else {
            lifeLabel.text = "남은 목숨 : \(0)"
            makeAlertDialog(title: "실패", message: "정답\(123)")
        }
        
    }
    
    
    private func initBtn(){
        let backButton = UIBarButtonItem(title: "", style: .plain, target: self, action: #selector(backButtonTapped))
        backButton.image = UIImage(systemName: "chevron.left") // iOS 기본 chevron 이미지를 사용
        navigationItem.leftBarButtonItem = backButton
    }
    
    @objc func backButtonTapped() {
        dismiss(animated: true, completion: nil)
    }
    
    private func initLifeLabel(){
        lifeLabel.text = "남은 목숨 : \(lifeCount!.lifes)"
    }

    // Alert Dialog 생성
    func makeAlertDialog(title: String, message: String, _ isAlert : Bool = true) {

        let alert = isAlert ? UIAlertController(title: title, message: message, preferredStyle: .alert)
        
        : UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        let alertDeleteBtn = UIAlertAction(title: "재시작", style: .default) { (action) in
            print("재시작 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        let alertSuccessBtn = UIAlertAction(title: "나가기", style: .destructive) { (action) in
            print("나가기 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        
        if(isAlert) {
            alert.addAction(alertDeleteBtn)
            alert.addAction(alertSuccessBtn)
        }
        else {
            alert.addAction(alertSuccessBtn)
            alert.addAction(alertDeleteBtn)
        }
        
        self.present(alert, animated: true, completion: nil)
    }
    

}

