1. Setup
lu1 host: install ansible
lu17n1 host: install ssh server
generate rsa key pair:
  lu17n1: ~/.ssh/authorized_key contains the pubic key
  lu1: ~/.ssh/id_rsa is the private key
  on lu1: $ ssh-agent bash
          $ ssh-add ~/.ssh/id_rsa

  cp -R /etc/ansible myplatform
  myplatform/hosts has the host lu17n1

2. from lu1
  $ pwd
/home/lxdeng/github/lxdeng/sandbox/dev/ansible/myplatform
lxdeng@lu1:~/github/lxdeng/sandbox/dev/ansible/myplatform$ ansible all -m ping
lu17n1 | SUCCESS => {
    "changed": false, 
    "ping": "pong"
}

  $ ansible all -m shell -a 'hostname'
  $ ansible all -m shell -a 'df -h'
  $ ansible all -m shell -a 'whoami'
  
  # user module
  #  -K ask-sudo-pass -b become root by default
  $ ansible all -b -K -m user -a 'name=testuser'
  $ ansible all -m shell -a 'id -u testuser'
