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
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initBtn()
        initLifeLabel()
        
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


}

