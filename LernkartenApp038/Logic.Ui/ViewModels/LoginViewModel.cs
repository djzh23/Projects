using De.HsFlensburg.LernkartenApp038.Logic.Ui.ServiceBusMessages;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels.Common;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using De.HsFlensburg.LernkartenApp038.Services.MediatorServiceBus;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels
{
    public class LoginViewModel : AbstractViewModel
    {
        public RelayCommand OpenEmailWindowCommand { get; }
        private string instertedUserEmail;
        public String InsertedUserEmail
        {
            get
            {
                return this.instertedUserEmail;
            }
            set
            {
                this.instertedUserEmail = value;
                OnPropertyChanged();
            }
        }
        private string smtp;
        public String Smtp
        {
            get
            {
                return this.instertedUserEmail;
            }
            set
            {
                this.smtp = value;
                OnPropertyChanged();
            }
        }


        private string insertedUserPassword;
        public String InsertedUserPassword { get { return this.insertedUserPassword; } set { this.insertedUserPassword = value; OnPropertyChanged(); } }
        private string messageForUser; 
        public String MessageForUser
        {
            get { return this.messageForUser; }
            set{ this.messageForUser = value; OnPropertyChanged();  } 
        }
        public ListOfSetsViewModel Sets { get; set; }
        public LoginViewModel()
        {

            OpenEmailWindowCommand = new RelayCommand(() => OpenEmailWindow());
        }
        public LoginViewModel(ListOfSetsViewModel sets)
        {
            this.Sets = sets;

            OpenEmailWindowCommand = new RelayCommand(() => OpenEmailWindow());
        }


        /*  private bool IsEmail(string text)
          {
              return System.Text.RegularExpressions.Regex.IsMatch(text, @"\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*");
          }*/

    /*   public bool CheckPop3Connection(string Pop3Server, string Benutzer, string Passwort)
        {
            bool result = false;
            try
            {
                #region Objekte
                TcpClient Server;
                NetworkStream NetStrm;
                StreamReader reader;
                string Data;
                byte[] szData;
                string CRLF = "\r\n";
                #endregion

                #region Server erreichbar
                Server = new TcpClient(Pop3Server, 110);
                NetStrm = Server.GetStream();
                reader = new StreamReader(Server.GetStream());
                if (reader.ReadLine().Substring(0, 3).ToUpper() != "+OK")
                {
                    throw new Exception("Der Server konnte nicht erreicht werden.");
                }
                #endregion

                #region Benutzer akzeptiert
                Data = "USER " + Benutzer + CRLF;
                szData = System.Text.Encoding.ASCII.GetBytes(Data.ToCharArray());
                NetStrm.Write(szData, 0, szData.Length);
                if (reader.ReadLine().Substring(0, 3).ToUpper() != "+OK")
                {
                    throw new Exception("Der Benutzername wurde nicht erkannt.");
                }
                #endregion

                #region Passwort übergeben
                Data = "PASS " + Passwort + CRLF;
                szData = System.Text.Encoding.ASCII.GetBytes(Data.ToCharArray());
                NetStrm.Write(szData, 0, szData.Length);
                string text = reader.ReadLine();
                if (text.Substring(0, 3).ToUpper() != "+OK")
                {
                    throw new Exception(text.Replace("-ERR ", ""));
                }
                result = true;
                #endregion

                #region Verbindung schließen
                Data = "QUIT" + CRLF;
                szData = System.Text.Encoding.ASCII.GetBytes(Data.ToCharArray());
                NetStrm.Write(szData, 0, szData.Length);
                if (reader.ReadLine().Substring(0, 3).ToUpper() != "+OK")
                {
                    throw new Exception("Fehler beim Abmelden.");
                }
                NetStrm.Close();
                reader.Close();
                #endregion
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

            return result;
        }*/

        private void OpenEmailWindow()
        {


            ServiceBus.Instance.Send(new OpenEmailWindowMessage());





//if (CheckPop3Connection(smtp, instertedUserEmail, insertedUserPassword)) { }

            

            

            /*  this.MessageForUser = "";

            if (this.instertedUserEmail == "" || this.insertedUserPassword  =="")
            {
                this.MessageForUser = "Please insert your password and username!"; 
            }
            else if(this.instertedUserEmail    != "r" || this.insertedUserPassword != "s")
            {
                this.MessageForUser = "Your email or your Password is wrong!";
            }
            else
            {
                ServiceBus.Instance.Send(new OpenEmailWindowMessage());
            }*/
        }
    }
}
